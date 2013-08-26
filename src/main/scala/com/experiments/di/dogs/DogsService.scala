package com.experiments.di.dogs

import com.experiments.di._

class DogsService {
  def getByName(name: String): Configured[DogsServiceContext, Dog] = Configured {ctx =>
    ctx.dogsRepo.getByName(name)
  }

  def countByColor(color: String): Configured[DogsServiceContext, Int] = Configured {ctx =>
    ctx.dogsRepo.getAllByColor(color).size
  }
}

trait DogsServiceContext {
  val dogsRepo: DogsRepository
}

object DogsServiceContext {
  val dogsRepo: Configured[DogsServiceContext, DogsRepository] = Configured {_.dogsRepo}
}
