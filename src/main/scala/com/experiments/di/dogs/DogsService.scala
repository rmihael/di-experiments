package com.experiments.di.dogs

import com.experiments.di._

class DogsService {
  def getByName(name: String): Configured[Context, Dog] = Configured {ctx =>
    ctx.dogsRepo.getByName(name)
  }

  def countByColor(color: String): Configured[Context, Int] = Configured {ctx =>
    ctx.dogsRepo.getAllByColor(color).size
  }
}
