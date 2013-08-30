package com.experiments.di

import com.experiments.di.cats._
import com.experiments.di.dogs._

object CrazyOldLadyHouseService extends DI[CrazyOldLadyHouseServiceContext, Context] {
  def getCat(name: String): Configured[Cat] = for {
    ctx <- context
    c <- ctx.catsService.getByName(name)
  } yield c

  def getDog(name: String): Configured[Dog] = for {
    ctx <- context
    d <- ctx.dogsService.getByName(name)
  } yield d

  def getPair(catName: String, dogName: String): Configured[(Cat, Dog)] = for {
    ctx <- context
    c <- ctx.catsService.getByName(catName)
    d <- ctx.dogsService.getByName(dogName)
  } yield (c, d)
}

trait CrazyOldLadyHouseServiceContext {
  val catsService: CatsService
  val dogsService: DogsService
}
