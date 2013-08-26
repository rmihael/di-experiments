package com.experiments.di

import com.experiments.di.cats.{CatsRepository, CatsService}
import com.experiments.di.dogs.{DogsRepository, DogsService}

trait Context {
  val catsService: CatsService
  val dogsService: DogsService
  val catsRepo: CatsRepository
  val dogsRepo: DogsRepository
}

object Context {
  val catsService: Configured[CatsService] = Configured {_.catsService}
  val dogsService: Configured[DogsService] = Configured {_.dogsService}
  val catsRepo: Configured[CatsRepository] = Configured {_.catsRepo}
  val dogsRepo: Configured[DogsRepository] = Configured {_.dogsRepo}
}
