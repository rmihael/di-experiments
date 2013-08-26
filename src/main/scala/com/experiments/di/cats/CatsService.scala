package com.experiments.di.cats

import com.experiments.di._

class CatsService {
  def getByName(name: String): Configured[CatsServiceContext, Cat] = Configured {ctx =>
    ctx.catsRepo.getByName(name)
  }

  def countByColor(color: String): Configured[CatsServiceContext, Int] = Configured {ctx =>
    ctx.catsRepo.getAllByColor(color).size
  }
}

trait CatsServiceContext {
  val catsRepo: CatsRepository
}

object CatsServiceContext {
  val catsRepo: Configured[CatsServiceContext, CatsRepository] = Configured {_.catsRepo}
}
