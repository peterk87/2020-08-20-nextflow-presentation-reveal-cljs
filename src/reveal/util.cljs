(ns reveal.util)


(def color-green "color:rgb(39, 174, 96);")

(def style-green {:style color-green})

(defn style-height
  ([h u] (str "height:" h u ";"))
  ([h] (style-height h "em"))
  ([] (style-height "1" "em")))

(defn font-size-style
  [size]
  {:style (str "font-size:" size "em;")})

(def height-1em (style-height))
(def height-2em (style-height 2))
(def height-3em (style-height 3))

(defn img-stretch
  [filename]
  [:img.r-stretch {:data-src (str "img/" filename)}])

(defn img
  ([filename style attrs]
   [:img.plain (merge {:data-src (str "img/" filename) :style style}
                      attrs)])
  ([filename style]
   (img filename style {}))
  ([filename]
   (img filename height-1em {})))

(def data-auto-animate {:data-auto-animate "data-auto-animate"})

(def nextflow-citation
  "Tommaso et al. Nextflow enables reproducible computational workflows. Nat Biotechnol 35, 316–319 (2017). https://doi.org/10.1038/nbt.3820")

(def nf-core-citation
  "Ewels, P.A., Peltzer, A., Fillinger, S. et al. The nf-core framework for community-curated bioinformatics pipelines. Nat Biotechnol 38, 276–278 (2020). https://doi.org/10.1038/s41587-020-0439-x")