package com.hrms.hrmsproject.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrmsproject.business.abstracts.JobSeekerCheckService;
import com.hrms.hrmsproject.core.utilities.results.ErrorResult;
import com.hrms.hrmsproject.core.utilities.results.Result;
import com.hrms.hrmsproject.core.utilities.results.SuccessResult;
import com.hrms.hrmsproject.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrmsproject.entities.concretes.JobSeeker;
@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

	private JobSeekerDao jobSeekerDao;
	


	@Autowired
	public JobSeekerCheckManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result checkFirstName(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName().isEmpty()) {
			System.out.println("İsim alanı boş bırakılamaz.");
			return new ErrorResult();
		} else {
			if (jobSeeker.getFirstName().length() < 4) {
				System.out.println("İsim alanı 4 karakterden büyük olmalıdır.");
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkLastName(JobSeeker jobSeeker) {
		if (jobSeeker.getLastName().isEmpty()) {
			System.out.println("Soyisim alanı boş bırakılamaz.");
			return new ErrorResult();
		} else {
			if (jobSeeker.getLastName().length() < 4) {
				System.out.println("Soyisim alanı 4 karakterden büyük olmalıdır.");
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkNationalityId(JobSeeker jobSeeker) {
		if (jobSeeker.getNationalityId().isEmpty()) {
			System.out.println("Vatandaşlık kimlik numarası alanı boş bırakılamaz.");
			return new ErrorResult();
		} else {
			if (jobSeeker.getNationalityId().length() < 11 || jobSeeker.getNationalityId().length() > 11) {
				System.out.println("Vatandaşlık kimlik numarası 11 karakter olmalıdır.");
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkBirthYear(JobSeeker jobSeeker) {
		if (jobSeeker.getBirthYear() > 1930 && jobSeeker.getBirthYear() < 2021) {
			return new SuccessResult();
		} else {
			System.out.println("1930 - 2021 aralığında tarih giriniz.");
			return new ErrorResult();
		}

	}

	@Override
	public Result checkEmail(JobSeeker jobSeeker) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (jobSeeker.getEmail().isEmpty()) {
			System.out.println("Email alanı boş bırakılamaz.");
			return new ErrorResult();
		} else {
			if (pattern.matcher(jobSeeker.getEmail()).find() == false) {
				System.out.println("Girilen email adresi formata uygun değil. Örnek: ornek@ornek.com");
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkPassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().isEmpty()) {
			System.out.println("Soyisim alanı boş bırakılamaz.");
			return new ErrorResult();
		} else {
			if (jobSeeker.getPassword().length() < 6) {
				System.out.println("Parola 6 karakterden daha küçük olamaz.");
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkRepeatPassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPasswordCheck().isEmpty()) {
			return new ErrorResult("Parola doğrulama alanı boş bırakılamaz.");
		} else {
			if (jobSeeker.getPassword() == jobSeeker.getPasswordCheck()) {
				return new ErrorResult("Girilen parolalar eşleşmiyor.");
			}
		}	
		return new SuccessResult();
	}
	
	@Override
	public Result uniqueEmail(JobSeeker jobseeker) {
		if (jobSeekerDao.findByEmail(jobseeker.getEmail()) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result uniqueNationalityId(JobSeeker jobseeker) {
		if (jobSeekerDao.findByEmail(jobseeker.getNationalityId()) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	

}
