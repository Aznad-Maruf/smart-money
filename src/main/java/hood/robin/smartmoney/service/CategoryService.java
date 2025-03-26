package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryService implements BaseService<Category> {

    @PersistenceContext
    private EntityManager em;

    private final TransactionService transactionService;

    public CategoryService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Category find(UUID uuid) {
        return em.createNamedQuery("Category.findByUuid", Category.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @Transactional
    public Category save(Category category) {
        em.persist(category);

        return category;
    }

    @Transactional
    public Category update(Category category) {
        em.merge(category);

        return category;
    }

    @Transactional
    public Category delete(Category category) {
        // Check if category is used in transactions
        List<Transaction> transactions = transactionService.findByCategory(category);
        if (!transactions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category is used in transactions");
        }

        em.remove(category);

        return category;
    }

    public List<Category> findAll() {
        return em.createNamedQuery("Category.findAll", Category.class)
                .getResultList();
    }
}
