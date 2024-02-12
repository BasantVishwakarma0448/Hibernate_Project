package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dto.BaseDTO;
import com.dto.UserDTO;
import com.exception.ApplicationException;
import com.exception.RecordNotFoundException;
import com.model.ModelFactory;
import com.model.UserModelInt;
import com.util.DataUtility;
import com.util.DataValidator;
import com.util.PropertyReader;
import com.util.ServletUtility;

/**
 * Forget password ctl.To perform password send in email
 * 
 * @author Basant Vishwakarma
 *
 */
@WebServlet(urlPatterns = { "/ForgetPasswordCtl" })
public class ForgetPasswordCtl extends BaseCtl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ForgetPasswordCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", PropertyReader.getValue("error.require", "Email Id"));
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login", PropertyReader.getValue("error.email", "login"));
			pass = false;
		}
		return pass;

	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		UserDTO dto = new UserDTO();
		dto.setLogin(DataUtility.getString(request.getParameter("login")));
		populateBean(dto, request);
		return dto;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("do get method started");
		System.out.println("forget password......doget");
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("do get method started");
		String op = request.getParameter("operation");
		UserModelInt userModel = ModelFactory.getInstance().getUserModel();
		UserDTO dto = (UserDTO) populateDTO(request);
		if (OP_GO.equalsIgnoreCase(op)) {
			try {
				System.out.println(dto.getLogin());
				boolean flag = userModel.forgetPassword(dto.getLogin());
				ServletUtility.setSuccessMessage("password has been send to your login id", request);
				if (flag == true) {
					ServletUtility.forward(getView(), request, response);

				} else {
					ServletUtility.redirect(ORSView.ERROR_CTL, request, response);
					return;
				}

			} catch (RecordNotFoundException e) {
				ServletUtility.setErrorMessage(e.getMessage(), request);
				log.error(e);
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);

		}

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FORGET_PASSWORD_VIEW;
	}

}
