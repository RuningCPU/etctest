package com.wintime.read;

import com.wintime.data.DataSource;

public interface Readable<E> {
    public E read(DataSource dataSource);
}