package com.closs.core.types.core

interface DataSource<L : LocalSource, R : com.closs.core.types.core.RemoteSource> {
    val localSource: L
    val remoteSource: R
}
