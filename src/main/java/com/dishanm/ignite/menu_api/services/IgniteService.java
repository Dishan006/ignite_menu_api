package com.dishanm.ignite.menu_api.services;

import dishanm.ignite.Constants;
import dishanm.ignite.beans.Item;
import lombok.extern.log4j.Log4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.transactions.Transaction;
import org.apache.ignite.transactions.TransactionConcurrency;
import org.apache.ignite.transactions.TransactionIsolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j
public class IgniteService {

    @Autowired
    private Ignite ignite;

    public void addOrUpdateItemCache(Item item) {
        try (Transaction tx = ignite.transactions().txStart(TransactionConcurrency.OPTIMISTIC, TransactionIsolation.READ_COMMITTED)) {
            IgniteCache<Long, Item> cache = ignite.cache(Constants.ITEM_CACHE_NAME);
            cache.put(item.getId(), item);
            tx.commit();
            log.debug("Item Cache size after update:" + cache.size());
        }
    }

    public void addItemList(List<Item> items) {
        try (Transaction tx = ignite.transactions().txStart(TransactionConcurrency.OPTIMISTIC, TransactionIsolation.READ_COMMITTED)) {
            IgniteCache<Long, Item> cache = ignite.cache(Constants.ITEM_CACHE_NAME);
            items.forEach((item) -> cache.put(item.getId(), item));
            tx.commit();
            log.info("[Item Cache size after update:" + cache.size());
        }
    }

}
