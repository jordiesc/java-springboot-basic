FROM registry.redhat.io/ubi8/openjdk-8
LABEL "io.openshift.s2i.build.image"="registry.redhat.io/redhat-openjdk-18/openjdk18-openshift" \
      "io.openshift.s2i.scripts-url"="image:///usr/local/s2i" \
      "io.openshift.s2i.destination"="/tmp"

USER root
# Copying in source code
COPY . /tmp/src
#COPY /home/jordi/jordi/repositorios/github/sprign-securty-saml/target /tmp/src
# Change file ownership to the assemble user. Builder image must support chown command.
RUN chown -R 1001:0 /tmp/src
USER 1001
# Assemble script sourced from builder image based on user input or image metadata.
# If this file does not exist in the image, the build will fail.
RUN /usr/local/s2i/assemble
# Run script sourced from builder image based on user input or image metadata.
# If this file does not exist in the image, the build will fail.
CMD /usr/local/s2i/run