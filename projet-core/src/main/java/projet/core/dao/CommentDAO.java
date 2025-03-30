package projet.core.dao;

import projet.core.entity.Comment;

public interface CommentDAO extends GenericDAO<Comment>{
    Comment findCommentByAuthorName(String authorName);

    Comment findCommentById(long id);
}
