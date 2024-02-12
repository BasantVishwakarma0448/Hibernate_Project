package com.model;

import java.util.List;

import com.dto.CollegeDTO;
import com.exception.ApplicationException;
import com.exception.DuplicateRecordException;
/**
 * Interface of College model
 * @author Basant Vishwakarma
 *
 */
public interface CollegeModelInt {
public long add(CollegeDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(CollegeDTO dto)throws ApplicationException;
public void update(CollegeDTO dto)throws ApplicationException,DuplicateRecordException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(CollegeDTO dto)throws ApplicationException;
public List search(CollegeDTO dto,int pageNo,int pageSize)throws ApplicationException;
public CollegeDTO findByPK(long pk)throws ApplicationException;
public CollegeDTO fingByName(String name)throws ApplicationException;
}
