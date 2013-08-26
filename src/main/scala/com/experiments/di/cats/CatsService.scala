package com.experiments.di.cats

import com.experiments.di._

class CatsService {
  def getByName(name: String): Configured[Context, Cat] = Configured {ctx =>
    ctx.catsRepo.getByName(name)
  }

  def countByColor(color: String): Configured[Context, Int] = Configured {ctx =>
    ctx.catsRepo.getAllByColor(color).size
  }
}
