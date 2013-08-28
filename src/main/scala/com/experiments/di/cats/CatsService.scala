package com.experiments.di.cats

import com.experiments.di._
import com.experiments.di.Context

class CatsService extends DI[CatsServiceContext, Context] {
  def getByName(name: String): Configured[Cat] = for {
    ctx <- context
    cat = ctx.catsRepo.getByName(name)
  } yield cat

  def countByColor(color: String): Configured[Int] = for {
    ctx <- context
    count = ctx.catsRepo.getAllByColor(color).size
  } yield count
}

trait CatsServiceContext {
  val catsRepo: CatsRepository
}
