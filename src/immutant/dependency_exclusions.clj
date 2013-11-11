(ns immutant.dependency-exclusions
  (:require [leiningen.core.project :as project]))

(def immutant-libs
  #{'org.immutant/immutant
    'org.immutant/immutant-cache
    'org.immutant/immutant-common
    'org.immutant/immutant-daemons
    'org.immutant/immutant-jobs
    'org.immutant/immutant-messaging
    'org.immutant/immutant-web
    'org.immutant/immutant-xa})

(defn add-immutant-exclusions
  "Adds all public immutant artifacts as exclusions to a dep."
  [dep]
  (-> dep
      project/dependency-map
      (update-in [:exclusions]
                 #(concat % (map project/exclusion-map
                                 immutant-libs)))
      project/dependency-vec))

(defn exclude-immutant-deps
  "Removes public immutant artifacts from the deps list, and adds them
  as an exclusion to each remaining dep."
  [project]
  (update-in project
             [:dependencies]
             (fn [deps]
               (->> deps
                    (remove #(contains? immutant-libs (first %)))
                    (map add-immutant-exclusions)))))
