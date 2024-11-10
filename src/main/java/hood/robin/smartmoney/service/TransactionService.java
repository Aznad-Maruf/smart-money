package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @PersistenceContext
    private EntityManager em;

    public Transaction getTransaction(UUID uuid) {
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

    public List<Transaction> findAll() {
        return em.createNamedQuery("Transaction.findAll", Transaction.class)
                .getResultList();
    }
}
