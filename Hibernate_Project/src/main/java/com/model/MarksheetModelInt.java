package com.model;

import java.util.List;

import com.dto.MarksheetDTO;
import com.exception.ApplicationException;
import com.exception.DuplicateRecordException;

/**
 * Interface of Marksheet model
 * @author Basant Vishwakarma
 *
 */
public interface MarksheetModelInt {
public long add(MarksheetDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(MarksheetDTO dto)throws ApplicationException;
public void update(MarksheetDTO dto)throws ApplicationException,DuplicateRecordException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(MarksheetDTO dto)throws ApplicationException;
public List search(MarksheetDTO dto,int pageNo,int pageSize)throws ApplicationException;
public MarksheetDTO fingByPK(long pk)throws ApplicationException;
public MarksheetDTO findByRollNo(String rollNo)throws ApplicationException;
public List getMeritList(int pageNo,int pageSize)throws ApplicationException;
}
