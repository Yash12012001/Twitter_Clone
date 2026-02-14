package com.twitter.DBInstance.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.Constants.StatusCodes;
import com.twitter.CommonLibrary.DeleteUserDTO.DeleteUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataResBody;
import com.twitter.CommonLibrary.InsertUserDTO.InsertUserDataReqBody;
import com.twitter.CommonLibrary.UpdateUserDataDTO.UpdateUserDataReqBody;
import com.twitter.DBInstance.Entity.DataUser;
import com.twitter.DBInstance.Repository.IDataUserRepo;

@Service
public class UserDBSvc {

	@Autowired
	IDataUserRepo repo;

	// **************************** Service Logic For Updating User Data Start ********************************

	public ResponseEntity<Object> updateUserData(UpdateUserDataReqBody req) {

		try {
			if (req == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			if (req.getEmail() != null) {
				Optional<DataUser> fetchUserByEmail = repo.findById(req.getEmail());
				DataUser updatedUserData = fetchUserByEmail.get();
				int updateCounter = 0;

				if (req.getUserName() != null) {
					updatedUserData.setUsername(req.getUserName());
					updateCounter++;
				}
				if (req.getName() != null) {
					updatedUserData.setName(req.getName());
					updateCounter++;
				}
				if (req.getPassword() != null) {
					updatedUserData.setPassword(req.getPassword());
					updateCounter++;
				}

				if (updateCounter > 0) {

					repo.saveAndFlush(updatedUserData);
					Map<String, String> responseMap = new HashMap<>();

					responseMap.put("msg", "Data Updated Succsefully");

					return new ResponseEntity<>(responseMap, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("No New Data Found", HttpStatus.OK);
				}
			} else {

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "User Does Not Exsist, Please SignUp");

				return new ResponseEntity<>(responseMap, HttpStatus.NO_CONTENT);

			}

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}

	}
	// **************************** Service Logic For Updating User Data End ********************************

	// **************************** Service Logic For Delete User Data Start ********************************

	public ResponseEntity<Object> deleteUserData(DeleteUserDataReqBody req) {

		try {
			if (req == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Optional<DataUser> fetchUserByEmail = repo.findById(req.getEmail());

			if (fetchUserByEmail.isPresent()) {
				repo.delete(fetchUserByEmail.get());

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "User Deleted Succsesfully");

				return new ResponseEntity<>(responseMap, HttpStatus.NO_CONTENT);
			} else {
				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "User Does Not Exsist, Please SignUp");

				return new ResponseEntity<>(responseMap, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}

	}
	// **************************** Service Logic For Delete User Data End ********************************

	// **************************** Service Logic For Fetching User Data Start ********************************

	public ResponseEntity<Object> fetchUserData(FetchUserDataReqBody req) {
		try {
			if (req == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			if (req.getEmail() != null) {

				Optional<DataUser> fetchUserByEmail = repo.findById(req.getEmail());
				if (fetchUserByEmail.isEmpty()) {

					FetchUserDataResBody res = new FetchUserDataResBody();

					res.setStatus(StatusCodes.DataDoesNotExist);

					return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);

				} else {

					FetchUserDataResBody res = new FetchUserDataResBody();
					res.setStatus(StatusCodes.Sucess);
					res.setEmail(fetchUserByEmail.get().getEmail());
					res.setName(fetchUserByEmail.get().getName());
					res.setUsername(fetchUserByEmail.get().getUsername());
					res.setPassword(fetchUserByEmail.get().getPassword());

					return new ResponseEntity<>(res, HttpStatus.OK);
				}

			} else if (req.getUserName() != null) {
				Optional<DataUser> fetchUserByUserName = repo.findByUsername(req.getEmail());

				if (fetchUserByUserName.isEmpty()) {

					FetchUserDataResBody res = new FetchUserDataResBody();

					res.setStatus(StatusCodes.DataDoesNotExist);

					return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);

				} else {
					FetchUserDataResBody res = new FetchUserDataResBody();
					
					res.setStatus(StatusCodes.Sucess);
					res.setEmail(fetchUserByUserName.get().getEmail());
					res.setName(fetchUserByUserName.get().getName());
					res.setUsername(fetchUserByUserName.get().getUsername());
					res.setPassword(fetchUserByUserName.get().getUsername());

					return new ResponseEntity<>(res, HttpStatus.OK);
				}

			} else {
				FetchUserDataResBody res = new FetchUserDataResBody();

				res.setStatus(StatusCodes.DataDoesNotExist);
				
				return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);

			}

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

		}

	}
	// **************************** Service Logic For Fetching User Data End ***********************************

	// **************************** Service Logic For Inserting User Data Start ********************************

	public ResponseEntity<Object> insertUserData(InsertUserDataReqBody req) {

		try {

			if (req == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Optional<DataUser> checkUserByEmail = repo.findById(req.getEmail());

			Optional<DataUser> checkUserName = repo.findByUsername(req.getEmail());

			if (checkUserByEmail.isPresent()) {

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "User Already Exsist, Please Login");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			} else if (checkUserName.isPresent()) {

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "Username Already Exsist, Please try a different Username");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);

			} else {
				DataUser user = new DataUser();
				user.setUsername(req.getUsername());
				user.setEmail(req.getEmail());
				user.setName(req.getName());
				user.setPassword(req.getPassword());
				repo.save(user);

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "User Created");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);

			}

		} catch (DataIntegrityViolationException e) {

			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Username already Taken, Please Try Again with a different Username");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

		}

	}
	// **************************** Service Logic For Inserting User Data End ********************************

}
