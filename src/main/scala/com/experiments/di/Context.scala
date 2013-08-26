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
  val catsService: Configured[Context, CatsService] = Configured {_.catsService}
  val dogsService: Configured[Context, DogsService] = Configured {_.dogsService}
  val catsRepo: Configured[Context, CatsRepository] = Configured {_.catsRepo}
  val dogsRepo: Configured[Context, DogsRepository] = Configured {_.dogsRepo}
}
