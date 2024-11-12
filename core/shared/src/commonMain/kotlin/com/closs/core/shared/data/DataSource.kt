package com.closs.core.shared.data

interface DataSource<L : LocalSource, R : RemoteSource> {
    val localSource: L
    val remoteSource: R
}
