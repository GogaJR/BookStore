package am.project.controllers;

import am.project.forms.BookForm;
import am.project.models.Book;
import am.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getMainPage(ModelMap modelMap) {
        List<Book> books = bookService.getAllBooks();
        List<BookForm> booksForm = new ArrayList<>();

        for(Book book : books) {
            BookForm bookForm = BookForm.from(book);
            booksForm.add(bookForm);
        }

        modelMap.addAttribute("books", booksForm);

        return "mainPage";
    }

    @PostMapping("/")
    public RedirectView addBook(HttpServletRequest request, RedirectAttributes attributes) {
        String option = request.getParameter("button");
        if(option.equals("add")) {
            return new RedirectView("/addBook");
        }

        String authorName = request.getParameter("authorName");
        String authorSurname = request.getParameter("authorSurname");

        if(!authorName.isEmpty()) {
            attributes.addFlashAttribute("authorName", authorName);
        }

        if(!authorSurname.isEmpty()) {
            attributes.addFlashAttribute("authorSurname", authorSurname);
        }

        return new RedirectView("/search");
    }
}
