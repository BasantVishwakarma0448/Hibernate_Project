package com.model;

import java.util.List;

import com.dto.SubjectDTO;
import com.exception.ApplicationException;
import com.exception.DuplicateRecordException;
import com.mchange.util.DuplicateElementException;

/**
 * Interface of Subject model
 * @author Basant Vishwakarma
 *
 */
public interface SubjectModelInt {
public long add(SubjectDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(SubjectDTO dto)throws ApplicationException;
public void update(SubjectDTO dto)throws ApplicationException,DuplicateRecordException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(SubjectDTO dto)throws ApplicationException;
public List search(SubjectDTO dto,int pageNo,int pageSize)throws ApplicationException;
public SubjectDTO findByPK(long pk)throws ApplicationException;
public SubjectDTO findByName(String name)throws ApplicationException;
}
