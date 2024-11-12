package com.closs.core.types.data

interface DataSource<L : LocalSource, R : RemoteSource> {
    val localSource: L
    val remoteSource: R
}
