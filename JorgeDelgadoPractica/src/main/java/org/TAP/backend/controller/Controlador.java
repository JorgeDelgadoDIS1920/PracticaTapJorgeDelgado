package org.TAP.backend.controller;

import org.TAP.backend.model.IIdentificable;
import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.SensorBooleano;
import org.TAP.backend.model.SensorNumerico;

import java.io.Serializable;
import java.util.*;

public abstract class Controlador<T extends IIdentificable & Serializable> {


    private final HashMap<Long, T> datos = new HashMap<>();
    private long nextId = 0;

    public Controlador() {
        this.ensureTestData();
    }


    /**
     * @return all available Customer objects.
     */
    public synchronized List<T> findAll() {
        return findAll(null);
    }

    /**
     * Finds all Customer's that match given filter.
     *
     * @param stringFilter filter that returned objects should match or null/empty string
     *                     if all objects should be returned.
     * @return list a Customer objects
     */
    public synchronized List<T> findAll(String stringFilter) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T dato : datos.values()) {
            boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                    || dato.toString().toLowerCase().contains(stringFilter.toLowerCase());
            if (passesFilter) {
                try {
                    arrayList.add((T) dato.clonar());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.sort(arrayList, new Comparator<T>() {

            @Override
            public int compare(T o1, T o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });
        return arrayList;
    }

    /**
     * Finds all Customer's that match given filter and limits the resultset.
     *
     * @param stringFilter filter that returned objects should match or null/empty string
     *                     if all objects should be returned.
     * @param start        the index of first result
     * @param maxresults   maximum result count
     * @return list a Customer objects
     */
    public synchronized List<T> findAll(String stringFilter, int start, int maxresults) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T dato : datos.values()) {
            boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                    || dato.toString().toLowerCase().contains(stringFilter.toLowerCase());
            if (passesFilter) {
                try {
                    arrayList.add((T) dato.clonar());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.sort(arrayList, new Comparator<T>() {

            @Override
            public int compare(T o1, T o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });
        int end = start + maxresults;
        if (end > arrayList.size()) {
            end = arrayList.size();
        }
        return arrayList.subList(start, end);
    }

    /**
     * @return the amount of all customers in the system
     */
    public synchronized long count() {
        return datos.size();
    }

    /**
     * Deletes a customer from a system
     *
     * @param value the Customer to be deleted
     */
    public synchronized void delete(T value) {
        datos.remove(value.getId());
    }

    /**
     * Persists or updates customer in the system. Also assigns an identifier
     * for new Customer instances.
     *
     * @param entry
     */
    public synchronized void save(T entry) {
        if (entry == null) {
            return;
        }
        if (entry.getId() == -1) {
            entry.setId(nextId++);
        }
        try {
            entry = (T) entry.clonar();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        datos.put(entry.getId(), entry);
    }

    /**
     * Sample data generation
     */
    public abstract void ensureTestData();


}

