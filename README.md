# lump

Dorking around with cljs.

## Usage

For a browser REPL:

```bash
$ lein do cljsbuild once, repl
```

```clojure
(def repl-env (reset! cemerick.austin.repls/browser-repl-env
                      (cemerick.austin/repl-env)))
(cemerick.austin.repls/cljs-repl repl-env)
```

## License

Copyright © 2014 Brett Hoerner

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
