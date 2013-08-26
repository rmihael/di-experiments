package com.experiments.di

import com.experiments.di.dogs.{DummyDogsRepository, DogsRepository, DogsService}
import com.experiments.di.cats.{DummyCatsRepository, CatsRepository, CatsService}

object Main {
  val context = new Context {
    val catsRepo: CatsRepository = DummyCatsRepository
    val catsService: CatsService = new CatsService
    val dogsRepo: DogsRepository = DummyDogsRepository
    val dogsService: DogsService = new DogsService
  }

  def main(args: Array[String]): Unit = {
    val (cat, dog) = CrazyOldLadyHouseService.getPair("kitty", "doggie")(context)
    println(cat)
    println(dog)
  }
}
