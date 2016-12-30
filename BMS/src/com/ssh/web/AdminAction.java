package com.ssh.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Admin;
import com.ssh.entity.BookInfo;
import com.ssh.entity.BookType;
import com.ssh.service.AdminService;
import com.ssh.service.BookInfoService;
import com.ssh.service.BookTypeService;

@Controller
@RequestMapping("/adminAction")
public class AdminAction {
	//注入
	@Resource
	private AdminService adminService ;
	@Resource
	private BookTypeService bookTypeService;
	@Resource
	private BookInfoService bookInfoService;

	/**
	 * 
	 * @param admin 管理员
	 * @param response 
	 * @param out
	 * @return
	 */
	//添加管理员
	@RequestMapping("/addAdmin")
	public String addAdmin(Admin admin,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(adminService.addAdmin(admin)){
			out.print("<script>alert('添加成功');location.href='admin/addAdmin.jsp';<script>");
		}else{
			out.print("<script>alert('添加失败');location.href='admin/addAdmin.jsp';<script>");
		}
		return null;
	}
	//管理员登录
	@RequestMapping("/dengLu")
	public String dengLu(Admin admin,HttpServletResponse response,HttpServletRequest request,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		Admin loginUser=adminService.login(admin);
		if(loginUser!=null){
			loginUser.setApwd(null);;//清空密码
			//记录用户登录状态
			request.getSession().setAttribute("LoginUser", loginUser);
			return "redirect:/admin/welcome.jsp";
		}else{
			out.print("<script>alert('用户名和密码不正确!');history.back();</script>");
		}
		out.close();
		return null;
	}
	/**
	 * 
	 * @param type 图书类型管理
	 * @param response
	 * @param out
	 * @return
	 */
	//添加图书类型
	@RequestMapping("/addBookType")
	public String addBookType(BookType type,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookTypeService.addBookType(type)){
			out.print("<script>alert('添加成功');<script>");
		}else{
			out.print("<script>alert('添加失败');history.back();<script>");
		}
		return "pages/tb_bookType";
	}
	//查询出所有的图书类型信息
	@RequestMapping("/showBookType")
	@ResponseBody
	public List showBookType(){
		return bookTypeService.showAllBookType();
	}
	//去到修改图书类型信息
	@RequestMapping("/toUpdateBookType")
	public String toUpdateBookType(BookType type,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("cls",bookTypeService.getBookTypeById(type.getTid()));
		return "pages/tb_updateBookType";
	}
	//修改图书类型
	@RequestMapping("/updateBookType")
	public String updateBookType(BookType type,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookTypeService.updateBookType(type)){
			out.print("<script>alert('修改成功');<script>");
		}else{
			out.print("<script>alert('修改失败');history.back();<script>");
		}
		return "pages/tb_bookType";
	}
	//删除图书类型
	@RequestMapping("/deleteBookType")
	@ResponseBody
	public String deleteBookType(@RequestParam("tid")int id,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		if(bookTypeService.deleteBookType(bookTypeService.getBookTypeById(id))){
			return "scuess";
		}else{
			return "error";
		}
	}
	/**
	 * 
	 * @param book 图书管理
	 * @param response
	 * @param out
	 * @return
	 */
	//查询出图书的类型
	@RequestMapping("/bookType")
	public String bookType(BookType type,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("showBookType", bookTypeService.showAllBookType());
		return "pages/tb_book";
	}
	//添加图书类型
	@RequestMapping("/addBooks")
	public String addBooks(BookInfo book,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookInfoService.addBook(book)){
			out.print("<script>alert('添加成功');<script>");
		}else{
			out.print("<script>alert('添加失败');history.back();<script>");
		}
		return "pages/tb_book";
	}
	//查询出所有的图书信息
	@RequestMapping("/showBook")
	@ResponseBody
	public List showBook(){
		return bookInfoService.showAllBook();
	}
	//去到修改图书类型信息
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(BookInfo book,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("cls",bookInfoService.getBookById(book.getBid()));
		return "pages/tb_updateBook";
	}
	//修改图书类型
	@RequestMapping("/updateBook")
	public String updateBook(BookInfo book,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookInfoService.updateBook(book)){
			out.print("<script>alert('修改成功');<script>");
		}else{
			out.print("<script>alert('修改失败');history.back();<script>");
		}
		return "pages/tb_book";
	}
	//删除图书类型
	@RequestMapping("/deleteBook")
	@ResponseBody
	public String deleteBook(@RequestParam("bid")int id,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		if(bookInfoService.delBook(bookInfoService.getBookById(id))){
			return "scuess";
		}else{
			return "error";
		}
	}
	//依赖注入
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public void setBookTypeService(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService;
	}
	public void setBookInfoService(BookInfoService bookInfoService) {
		this.bookInfoService = bookInfoService;
	}
}
