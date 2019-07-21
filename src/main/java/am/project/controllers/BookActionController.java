package am.project.controllers;

import am.project.models.Author;
import am.project.models.Book;
import am.project.services.AuthorService;
import am.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookActionController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("bookInfo/update")
    public String getUpdateActionPage(@RequestParam(name = "bookId") String id, ModelMap modelMap) {
        int bookId = Integer.parseInt(id);
        Book book = bookService.getBookById(bookId);
        modelMap.addAttribute("book", book);

        return "updateBook";
    }

    @PostMapping("bookInfo/update")
    public String updateBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        String title = request.getParameter("title");
        String authorName = request.getParameter("authorName");
        String authorSurname = request.getParameter("authorSurname");

        Book book = bookService.getBookById(bookId);
        book.setTitle(title);
        Author author;
        int id = authorService.isAuthorPresent(authorName, authorSurname);
        if(id == 0) {
            authorService.addAuthor(authorName, authorSurname);
            author = authorService.getLastAuthor();
        } else {
            author = authorService.getAuthorById(id);
        }

        book.setAuthor(author);
        bookService.updateBook(book);

        Author oldAuthor = authorService.getAuthorById(authorId);
        if(oldAuthor.getBooks().isEmpty()) {
            authorService.deleteAuthor(authorId);
        }

        return "redirect:/";
    }

    @GetMapping("bookInfo/delete")
    public String getDeletePage(@RequestParam(name = "bookId") String id) {
        int bookId = Integer.parseInt(id);
        bookService.deleteBook(bookId);

        return "redirect:/";
    }
}

