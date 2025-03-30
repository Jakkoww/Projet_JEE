package projet.core.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import projet.core.dao.CommentDAO;
import projet.core.entity.Comment;

import java.util.List;

@Service
@Transactional
public class CommentService extends GenericService<Comment> {

    private final CommentDAO commentDAO;

    protected CommentService(CommentDAO commentDAO) {
        super(commentDAO);
        this.commentDAO = commentDAO;
    }

    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    public Comment findByAuthorName(String authorName) {
        return commentDAO.findCommentByAuthorName(authorName);
    }

    public Comment findById(long commentId) {
        return commentDAO.findCommentById(commentId);
    }

    public Comment create(Comment comment) {
        return commentDAO.save(comment);
    }

    public void deleteReport(long commentId) {
        commentDAO.deleteById(commentId);
    }
}
