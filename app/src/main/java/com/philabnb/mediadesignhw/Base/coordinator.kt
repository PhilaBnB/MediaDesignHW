package com.philabnb.mediadesignhw.Base

import org.koin.dsl.module

val coordinator = module {
    single { Navigator() }
}