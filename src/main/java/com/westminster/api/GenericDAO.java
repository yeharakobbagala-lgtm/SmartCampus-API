/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.util.List;

public class GenericDAO<T extends BaseModel> {
    private final List<T> items;

    public GenericDAO(List<T> items) {
        this.items = items;
    }

    public List<T> getAll() {
        return items;
    }

    public T getById(int id) {
        for (T item : items) {
            if (item.getId() == id) { return item; }
        }
        return null;
    }

    public void add(T item) {
    // Just add the item exactly as it came from Postman!
    items.add(item);
}

    public boolean delete(int id) {
        items.removeIf(item -> item.getId() == id);
        return false;
    }
}