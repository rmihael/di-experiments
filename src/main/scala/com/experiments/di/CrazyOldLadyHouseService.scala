package com.experiments.di

import com.experiments.di.cats._
import com.experiments.di.dogs._

object CrazyOldLadyHouseService {
  def getCat(name: String): Configured[CrazyOldLadyHouseServiceContext with CatsServiceContext, Cat] = for {
    s <- CrazyOldLadyHouseServiceContext.catsService
    c <- s.getByName(name)
  } yield c

  def getDog(name: String): Configured[CrazyOldLadyHouseServiceContext with DogsServiceContext, Dog] = for {
    s <- CrazyOldLadyHouseServiceContext.dogsService
    c <- s.getByName(name)
  } yield c

  def getPair(catName: String, dogName: String): Configured[CrazyOldLadyHouseServiceContext with CatsServiceContext with DogsServiceContext, (Cat, Dog)] = for {
    cs <- CrazyOldLadyHouseServiceContext.catsService
    c <- cs.getByName(catName)
    ds <- CrazyOldLadyHouseServiceContext.dogsService
    d <- ds.getByName(dogName)
  } yield (c, d)
}

trait CrazyOldLadyHouseServiceContext {
  val catsService: CatsService
  val dogsService: DogsService
}

object CrazyOldLadyHouseServiceContext {
  val catsService: Configured[CrazyOldLadyHouseServiceContext, CatsService] = Configured {_.catsService}
  val dogsService: Configured[CrazyOldLadyHouseServiceContext, DogsService] = Configured {_.dogsService}
}
