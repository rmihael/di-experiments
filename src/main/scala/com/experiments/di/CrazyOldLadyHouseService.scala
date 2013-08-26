package com.experiments.di

import com.experiments.di.cats._
import com.experiments.di.dogs._

object CrazyOldLadyHouseService {
  def getCat(name: String): Configured[Cat] = for {
    s <- Context.catsService
    c <- s.getByName(name)
  } yield c

  def getDog(name: String): Configured[Dog] = for {
    s <- Context.dogsService
    c <- s.getByName(name)
  } yield c

  def getPair(catName: String, dogName: String): Configured[(Cat, Dog)] = for {
    cs <- Context.catsService
    c <- cs.getByName(catName)
    ds <- Context.dogsService
    d <- ds.getByName(dogName)
  } yield (c, d)
}
