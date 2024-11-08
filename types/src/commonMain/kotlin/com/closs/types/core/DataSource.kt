package com.closs.types.core

interface DataSource<L : LocalSource, R : RemoteSource> {
    val localSource: L
    val remoteSource: R
}
