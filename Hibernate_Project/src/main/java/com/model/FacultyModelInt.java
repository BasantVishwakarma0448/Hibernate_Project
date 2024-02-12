package com.model;

import java.util.List;

import com.dto.FacultyDTO;
import com.exception.ApplicationException;
import com.exception.DatabaseException;
import com.exception.DuplicateRecordException;

/**
 * Interface of Faculty model
 * @author Basant Vishwakarma
 *
 */
public interface FacultyModelInt {
public long add(FacultyDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(FacultyDTO dto)throws ApplicationException;
public void update(FacultyDTO dto)throws ApplicationException,DatabaseException, DuplicateRecordException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(FacultyDTO dto)throws ApplicationException;
public List search(FacultyDTO dto,int pageNo,int pageSize)throws ApplicationException;
public FacultyDTO findByPK(long pk)throws ApplicationException;
public FacultyDTO  findByEmailId(String emailId)throws ApplicationException;
}
