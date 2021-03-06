package kr.co.cgs4.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.cgs4.dao.BookDAO;
import kr.co.cgs4.dao.CinemaDAO;
import kr.co.cgs4.dao.FilmDAO;
import kr.co.cgs4.dto.Book_ScreenNum;
import kr.co.cgs4.dto.Book_ScreeningInfo;
import kr.co.cgs4.dto.Book_SeatCnt;
import kr.co.cgs4.dto.FilmDTO;
import kr.co.cgs4.dto.ScreenDTO;
import kr.co.cgs4.dto.SiteDTO;
import kr.co.cgs4.dto.TrailerDTO;

public class MovieCommand implements Command{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String film_ID = request.getParameter("film_ID");
		FilmDAO dao = new FilmDAO();
		FilmDTO dto = dao.film(film_ID);
		ArrayList<TrailerDTO> tdto = dao.trailer(film_ID);
		model.addAttribute("film", dto);
		model.addAttribute("trailer", tdto);
		request.setAttribute("film_name", dto.getFilm_name());
		BookDAO bdao = new BookDAO();
		CinemaDAO cdao=new CinemaDAO();
		ArrayList<SiteDTO> dtos3=cdao.total_site();
		model.addAttribute("t_site", dtos3);
		//리퀘스트 받아온 값이 null이 아닐때만 좌석정보 불러옴.
		if(request.getParameter("film_name")!=null){
			String film_name = request.getParameter("film_name");
			System.out.println(film_name);
			String site_name = request.getParameter("site_name");
			System.out.println(site_name);
			String sScreening_date = request.getParameter("screening_date");
			Date screening_date = java.sql.Date.valueOf(sScreening_date);
			List<Book_SeatCnt> sCnt = bdao.saleCnt();
			ArrayList<Book_ScreeningInfo> bdto = bdao.screening_date(film_name, site_name, screening_date);
			ArrayList<Book_ScreenNum> scdto = bdao.screening_num(film_name, site_name, screening_date);
			model.addAttribute("scnt", sCnt);
			model.addAttribute("blist", bdto);
			model.addAttribute("scNum", scdto);
		}
	}
}
