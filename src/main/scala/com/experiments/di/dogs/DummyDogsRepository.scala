package com.experiments.di.dogs

object DummyDogsRepository extends DogsRepository {
  def getByName(name: String): Dog = Dog(name, "black")

  def getAllByColor(color: String): Set[Dog] = Set(Dog("Cabaret", color), Dog("Caddy", color), Dog("Caboodle", color))
}
