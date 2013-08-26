package com.experiments.di

import com.experiments.di.dogs.{DogsServiceContext, DummyDogsRepository, DogsRepository, DogsService}
import com.experiments.di.cats.{CatsServiceContext, DummyCatsRepository, CatsRepository, CatsService}

object Main {
  val context = new CrazyOldLadyHouseServiceContext with CatsServiceContext with DogsServiceContext {
    val catsService: CatsService = new CatsService
    val dogsService: DogsService = new DogsService
    val catsRepo: CatsRepository = DummyCatsRepository
    val dogsRepo: DogsRepository = DummyDogsRepository
  }

  def main(args: Array[String]): Unit = {
    val (cat, dog) = CrazyOldLadyHouseService.getPair("kitty", "doggie")(context)
    println(cat)
    println(dog)
  }
}
