# for 4A on FF-RC1, we need to enable DYNAPI mechanism at binder level
# it should be removed in final release of FF and SPEC-1546 is opened to 
# track that task.

EXTRA_OECMAKE_append_class-target += "-DINCLUDE_LEGACY_BINDING_VDYN=ON"
