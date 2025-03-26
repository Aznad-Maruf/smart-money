package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService implements BaseService<Transaction>{

    @PersistenceContext
    private EntityManager em;

    public Transaction find(UUID uuid) {
        return em.createNamedQuery("Transaction.findByUuid", Transaction.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @Transactional
    public Transaction save(Transaction transaction) {
        em.persist(transaction);

        return transaction;
    }

    @Transactional
    public Transaction update(Transaction transaction) {
        return em.merge(transaction);
    }

    @Transactional
    public Transaction delete(Transaction transaction) {
        em.remove(transaction);

        return transaction;
    }

    public List<Transaction> findAll() {
        return em.createNamedQuery("Transaction.findAll", Transaction.class)
                .getResultList();
    }

    public List<Transaction> findByCategory(Category category) {
        return em.createNamedQuery("Transaction.findByCategory", Transaction.class)
                .setParameter("category", category)
                .getResultList();
    }
}
