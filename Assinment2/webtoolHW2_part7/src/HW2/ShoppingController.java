package HW2;
import Bean.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingController
 */
@WebServlet("/ShoppingController")
public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Product> productList;
	@Override
	public void init() {
		productList =new ArrayList<>();
		for(int i=0;i<10;i++) {
			Random chooser = new Random();
			Product book = new Product();
			book.setName("book" + i);
			book.setPrice((Double)(1.0 + chooser.nextInt(50)));
			book.setType("Books");
			productList.add(book);
		}
		for(int i=0;i<10;i++) {
			Random chooser = new Random();
			Product music = new Product();
			music.setName("music" + i);
			music.setPrice((Double)(1.0 + chooser.nextInt(50)));
			music.setType("Music");
			productList.add(music);
		}
		for(int i=0;i<10;i++) {
			Random chooser = new Random();
			Product computer = new Product();
			computer.setName("computer" + i);
			computer.setPrice((Double)(1.0 + chooser.nextInt(50)));
			computer.setType("Computers");
			productList.add(computer);
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out =response.getWriter();
    	HttpSession session = request.getSession(false);
    	//Navigating to Showing Product
    	if(request.getParameter("type")!=null) {
    		ArrayList<Product> selectedList = new ArrayList<>();
    		for(Product product:productList) {
    			if(product.getType().equals(request.getParameter("type"))) {
    				selectedList.add(product);
        			session.setAttribute("selectedProducts", selectedList);
    			}
    		}
    		RequestDispatcher rd = request.getRequestDispatcher("showProduct.jsp?type=" + request.getParameter("type"));
            rd.forward(request, response);
    	}
    	
    	//Navigating to MyCart
    	if(request.getParameter("nav")!=null) {
    		if(request.getParameter("nav").equals("myCart")) {
    			RequestDispatcher rd = request.getRequestDispatcher("myCart.jsp");
                rd.forward(request, response);
        	}
    	};
    	
    	
    	//Retrieve Shopping Cart From Session
    	ArrayList<Product> myCart = (ArrayList<Product>)session.getAttribute("myCart");
    	if(myCart==null) {
    		myCart = new ArrayList<>();
    	}
    	
    	//Adding Product into myCart
    	if(request.getParameter("action")!=null) {
    		String action = request.getParameter("action");
    		if(action.equals("add")) {
        		if(request.getParameter("chkProduct")!=null) {
        			String[] idList = request.getParameterValues("chkProduct");
        			for(Product product: productList) {
        				for(String id : idList) {
        					System.out.println(id);
        					if(String.valueOf(product.getId()).equals(id)) {
        						myCart.add(product);
        					}
        				}
        			}
        			session.setAttribute("myCart", myCart);
        			RequestDispatcher rd = request.getRequestDispatcher("addResult.jsp");
                    rd.forward(request, response);
        		}		
        	}
    	}

    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
