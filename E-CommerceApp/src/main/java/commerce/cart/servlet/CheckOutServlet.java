package commerce.cart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commerce.cart.model.Cart;
import commerce.cart.connection.DbCon;
import commerce.cart.dao.OrderDao;
import commerce.cart.model.*;
import commerce.cart.model.User;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			// retrieve all cart products
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			// User authentication
			User auth = (User) request.getSession().getAttribute("auth");

			// checking auth and cart list
			if (cart_list != null && auth != null) {

				for (Cart c : cart_list) {
					// Preparing the order object
					Order order = new Order();
					order.setId(c.getId());
					order.setUserId(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));

					// Instantiating the Dao Class
					OrderDao oDao = new OrderDao(DbCon.getConnection());
					boolean result = oDao.insertOrder(order);
					if (!result)
						break;
				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");

			} else {

				if (auth == null)
					response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
