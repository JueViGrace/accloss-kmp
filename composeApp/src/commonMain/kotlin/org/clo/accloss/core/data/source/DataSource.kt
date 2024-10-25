package org.clo.accloss.core.data.source

interface DataSource<L : LocalSource, R : RemoteSource> {
    val localSource: L
    val remoteSource: R
}
