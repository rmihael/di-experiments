package com.experiments.di.cats

object DummyCatsRepository extends CatsRepository{
  def getByName(name: String): Cat = Cat(name, "black")

  def getAllByColor(color: String): Set[Cat] = Set(Cat("Abbey", color), Cat("Abby", color), Cat("Abel", color))
}
