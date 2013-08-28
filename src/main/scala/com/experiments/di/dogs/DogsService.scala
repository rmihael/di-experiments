package com.experiments.di.dogs

import com.experiments.di._
import com.experiments.di.Context

class DogsService extends DI[DogsServiceContext, Context] {
  def getByName(name: String): Configured[Dog] = for {
    ctx <- context
    dog = ctx.dogsRepo.getByName(name)
  } yield dog

  def countByColor(color: String): Configured[Int] = for {
    ctx <- context
    count = ctx.dogsRepo.getAllByColor(color).size
  } yield count
}

trait DogsServiceContext {
  val dogsRepo: DogsRepository
}
