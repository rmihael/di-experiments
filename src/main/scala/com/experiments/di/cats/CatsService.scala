package com.experiments.di.cats

import com.experiments.di._

class CatsService {
  def getByName(name: String): Configured[Cat] = Configured {ctx =>
    ctx.catsRepo.getByName(name)
  }

  def countByColor(color: String): Configured[Int] = Configured {ctx =>
    ctx.catsRepo.getAllByColor(color).size
  }
}
