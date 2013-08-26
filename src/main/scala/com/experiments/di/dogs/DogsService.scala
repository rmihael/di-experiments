package com.experiments.di.dogs

import com.experiments.di._

class DogsService {
  def getByName(name: String): Configured[Dog] = Configured {ctx =>
    ctx.dogsRepo.getByName(name)
  }

  def getPairByNames(name1: String, name2: String): Configured[(Dog, Dog)] = for {
    d1 <- getByName(name1)
    d2 <- getByName(name2)
  } yield (d1, d2)
  
  def countByColor(color: String): Configured[Int] = Configured {ctx =>
    ctx.dogsRepo.getAllByColor(color).size
  }
}
