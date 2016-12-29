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
	//ע��
	@Resource
	private AdminService adminService ;
	@Resource
	private BookTypeService bookTypeService;
	@Resource
	private BookInfoService bookInfoService;

	/**
	 * 
	 * @param admin ����Ա
	 * @param response 
	 * @param out
	 * @return
	 */
	//��ӹ���Ա
	@RequestMapping("/addAdmin")
	public String addAdmin(Admin admin,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(adminService.addAdmin(admin)){
			out.print("<script>alert('��ӳɹ�');location.href='admin/addAdmin.jsp';<script>");
		}else{
			out.print("<script>alert('���ʧ��');location.href='admin/addAdmin.jsp';<script>");
		}
		return null;
	}
	//����Ա��¼
	@RequestMapping("/dengLu")
	public String dengLu(Admin admin,HttpServletResponse response,HttpServletRequest request,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		Admin loginUser=adminService.login(admin);
		if(loginUser!=null){
			loginUser.setApwd(null);;//�������
			//��¼�û���¼״̬
			request.getSession().setAttribute("LoginUser", loginUser);
			return "redirect:/admin/welcome.jsp";
		}else{
			out.print("<script>alert('�û��������벻��ȷ!');history.back();</script>");
		}
		out.close();
		return null;
	}
	/**
	 * 
	 * @param type ͼ�����͹���
	 * @param response
	 * @param out
	 * @return
	 */
	//���ͼ������
	@RequestMapping("/addBookType")
	public String addBookType(BookType type,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookTypeService.addBookType(type)){
			out.print("<script>alert('��ӳɹ�');<script>");
		}else{
			out.print("<script>alert('���ʧ��');history.back();<script>");
		}
		return "pages/tb_bookType";
	}
	//��ѯ�����е�ͼ��������Ϣ
	@RequestMapping("/showBookType")
	@ResponseBody
	public List showBookType(){
		return bookTypeService.showAllBookType();
	}
	//ȥ���޸�ͼ��������Ϣ
	@RequestMapping("/toUpdateBookType")
	public String toUpdateBookType(BookType type,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("cls",bookTypeService.getBookTypeById(type.getTid()));
		return "pages/tb_updateBookType";
	}
	//�޸�ͼ������
	@RequestMapping("/updateBookType")
	public String updateBookType(BookType type,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookTypeService.updateBookType(type)){
			out.print("<script>alert('�޸ĳɹ�');<script>");
		}else{
			out.print("<script>alert('�޸�ʧ��');history.back();<script>");
		}
		return "pages/tb_bookType";
	}
	//ɾ��ͼ������
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
	 * @param book ͼ�����
	 * @param response
	 * @param out
	 * @return
	 */
	//��ѯ��ͼ�������
	@RequestMapping("/bookType")
	public String bookType(BookType type,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("showBookType", bookTypeService.showAllBookType());
		return "pages/tb_book";
	}
	//���ͼ������
	@RequestMapping("/addBooks")
	public String addBooks(BookInfo book,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookInfoService.addBook(book)){
			out.print("<script>alert('��ӳɹ�');<script>");
		}else{
			out.print("<script>alert('���ʧ��');history.back();<script>");
		}
		return "pages/tb_book";
	}
	//��ѯ�����е�ͼ����Ϣ
	@RequestMapping("/showBook")
	@ResponseBody
	public List showBook(){
		return bookInfoService.showAllBook();
	}
	//ȥ���޸�ͼ��������Ϣ
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(BookInfo book,HttpServletRequest request,PrintWriter out){
		request.getSession().setAttribute("cls",bookInfoService.getBookById(book.getBid()));
		return "pages/tb_updateBook";
	}
	//�޸�ͼ������
	@RequestMapping("/updateBook")
	public String updateBook(BookInfo book,HttpServletResponse response,PrintWriter out){
		response.setContentType("text/html;charset=UTF-8");
		if(bookInfoService.updateBook(book)){
			out.print("<script>alert('�޸ĳɹ�');<script>");
		}else{
			out.print("<script>alert('�޸�ʧ��');history.back();<script>");
		}
		return "pages/tb_book";
	}
	//ɾ��ͼ������
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
	//����ע��
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
