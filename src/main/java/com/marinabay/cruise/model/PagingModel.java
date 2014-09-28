package com.marinabay.cruise.model;

/**
 * User: son.nguyen
 * Date: 9/24/14
 * Time: 10:29 PM
 */
public class PagingModel {

    private int limit;
    private int offset;
    private String search;
    private String name;
    private String order;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
