package com.example;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("total_count")
    private int totalCount;
    private int limit;
    private int offset;

    public Meta(int newLimit, int newOffset, int newTotalCount) {
        limit = newLimit;
        offset = newOffset;
        totalCount = newTotalCount;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
